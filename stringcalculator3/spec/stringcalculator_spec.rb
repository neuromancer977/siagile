require 'stringcalculator'

def sum(string)
  string.extend(StringCalculator).add
end

describe StringCalculator do
  it 'return sum of positive numbers' do
    cases = [
     ['',0],
     ['1',1],
     ['5',5],
     ['7',7],
     ['10',10],
     ['10,1',11],
     ['10,3',13],
     ['10,5',15],
     ['100,20,3',123],
     ['100,50,6',156],
     ["1\n2",3],
     ["1\n2,3",6],
     ["//;\n2;3;4",9],
     ["//@\n3@4@5",12],
    ].each do |string,expected|
      sum(string).should == expected
    end
  end

  it 'specify negative numbers in error message' do
    cases = [
      ['-1', '-1'],
      ['1,-2,3', '-2'],
      ['-1,2,-3','-1, -3']
    ].each do |string,negatives|
      lambda{sum(string)}.should raise_error "negative numbers: #{negatives}"
    end
  end
end

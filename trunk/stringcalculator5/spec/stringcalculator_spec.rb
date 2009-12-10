require 'stringcalculator'

describe StringCalculator do
  it 'return 0 for empty string' do
    "".total.should == 0
  end

  it 'return 1 for 1' do
    "1".total.should == 1
  end

  it 'return n for n' do
    cases = [
      ['5',5],
      ['7',7],
      ['10',10],
      ['10,1',11],
      ['10,2',12],
      ['100,20,3',123],
    ].each do |string,expected|
      string.total.should == expected
    end
  end

  it 'accept alternate delimiters' do
    cases = [
      ["1\n2",3],
      ["2\n3",5],
      ["//;\n3;4;5",12],
      ["//@\n4@5@6",15],
    ].each do |string,expected|
      string.total.should == expected
    end
  end

  it 'raise error for negatives' do
    cases = [
      ['-1','-1'],
      ['-1,2,-3','-1, -3'],
      ['-2,-3','-2, -3']
    ].each do |string,message|
      lambda{string.total}.should raise_error(message)
    end
  end
end

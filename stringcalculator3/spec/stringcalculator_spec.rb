require 'stringcalculator'

Spec::Matchers.define :add_to do |expected|
  match do |string|
    string.extend(StringCalculator).add.should == expected
  end
end

describe StringCalculator do
  it 'returns 0 for empty string' do
    ''.should add_to 0
  end

  context '1 number' do
    it 'returns 1 for 1' do
      '1'.should add_to 1
    end

    it 'returns 5 for 5' do
      '5'.should add_to 5
    end

    it 'return 7 for 7' do
      '7'.should add_to 7
    end

    it 'return 10 for 10' do
      '10'.should add_to 10
    end
  end

  context '2 numbers' do
    it 'returns 11 for 10,1' do
      '10,1'.should add_to 11
    end

    it 'returns 13 for 10,3' do
      '10,3'.should add_to 13
    end

    it 'return 15 for 10,5' do
      '10,5'.should add_to 15
    end
  end

  context '3 numbers' do
    it 'returns 123 for 100,20,3' do
      '100,20,3'.should add_to 123
    end

    it 'returns 156 for 100,50,6' do
      '100,50,6'.should add_to 156
    end
  end

  context 'delimiters' do
    it 'allow newline as delimiter' do
      "1\n2".should add_to 3
    end

    it 'allow both delimiters \n and ,' do
      "1,2\n3".should add_to 6
    end

    it 'allow delimiter definition' do
      "//;\n1;2;3".should add_to 6
    end

    it 'use @ as alternate delimiter' do
     "//@\n1@2@3".should add_to 6
    end
  end

  context 'negative numbers are not allowed' do
    it 'raise error when contains negative number' do
      lambda{"-1".extend(StringCalculator).add}.should raise_error
    end

    it 'specify negative numbers in error message' do
      lambda{'1,-2,3'.extend(StringCalculator).add}.should raise_error 'negative numbers: -2'
    end

    it 'some negatives' do
      lambda{'-1,2,-3'.extend(StringCalculator).add}.should raise_error 'negative numbers: -1, -3'
    end
  end
end

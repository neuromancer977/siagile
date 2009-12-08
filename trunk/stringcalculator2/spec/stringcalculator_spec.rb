require 'stringcalculator'

Spec::Matchers.define :add_to do |expected|
  match do |string|
    string.extend(StringCalculator).add.should == expected
  end
end

describe StringCalculator do
  it 'return 0 for empty string' do
    "".should add_to(0)
  end

  context 'single number' do
    it 'returns 0 for 0' do
      "0".should add_to(0)
    end

    it 'returns 5 for 5' do
      "5".should add_to(5)
    end

    it 'return 10 for 10' do
      "10".should add_to(10)
    end
  end

  context '2 numbers' do
    it 'returns 5 for 2,3' do
      "2,3".should add_to(5)
    end

    it 'return 11 for 10,1' do
      "10,1".should add_to(11)
    end
  end

  context '3 numbers' do
    it 'return 123 for 100,20,3' do
      "100,20,3".should add_to(123)
    end

    it 'return 1256 for 1000,200,56' do
      "1000,200,56".should add_to(1256)
    end
  end

  context 'delimiters' do
    it 'supports newline as delimiter' do
      "1\n2".should add_to(3)
    end

    it 'supports alternatives delimiters' do
      "//;\n1;2;3".should add_to(6)
    end
  end

  context 'negative numbers' do
    it 'raise error when find one negative number' do
      lambda{"-1".extend(StringCalculator).add}.should raise_error
    end

    it 'raise error and show negative numbers in message' do
      lambda{"-1,-2,3".extend(StringCalculator).add}.should raise_error("Negative numbers not allowed: -1, -2")
    end
  end
end

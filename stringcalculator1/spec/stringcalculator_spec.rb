require 'stringcalculator'

Spec::Matchers.define :add_to do |expected|
  match do |string|
    (@result = string.extend(StringCalculator).add).should == expected
  end
end

describe StringCalculator, '#add' do
  it 'returns 0 for empty string' do
    "".should add_to(0)
  end

  context 'single number' do
    it 'returns 0 for 0' do
      "0".should add_to(0)
    end

    it 'returns 5 for 5' do
     "5".should add_to(5)
    end

    it 'returns 27 for 27' do
      "27".should add_to(27)
    end
  end

  context 'two numbers' do
    it 'return 5 for 2,3' do
      "2,3".should add_to(5)
    end

    it 'return 13 for 10,3' do
      "10,3".should add_to(13)
    end
  end

  context 'three numbers' do
    it 'return 27 for 10,14,3' do
      "10,14,3".should add_to(27)
    end

    it 'return 1025 for 700,200,125' do
      "700,200,125".should add_to(1025)
    end
  end

  it 'supports newline as delimiter' do
    "2\n3".should add_to(5)
  end

  it 'supports mixed delimiter' do
    "2\n3,5".should add_to(10)
  end

  it 'supports alternate delimiter' do
    "//;\n1;2;3".should add_to(6)
  end

  context 'negative numbers' do
    it 'raise an exception if find one' do
      lambda {"-1".extend(StringCalculator).add}.should raise_error
    end

    it 'include negative numbers in error' do
      lambda {"-1,3,-2".extend(StringCalculator).add}.should raise_error('Negatives not allowed: -1, -2')
    end
  end
end

module StringCalculator
  def add
    return 0 if empty?
    negative_not_allowed
    digits.inject{ |sum,x| sum + x }
  end

  def negatives
    digits.select{|x| x < 0}.join(', ')
  end

  def negative_not_allowed
    raise "negative numbers: #{negatives}" unless negatives.empty?
  end

  def delimiter
    self[0,2] == '//' ? self[2,1] : ','
  end

  def digits
    gsub("\n", delimiter).split(delimiter).map{ |x| x.to_i }
  end
end

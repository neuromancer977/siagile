module StringCalculator
  def add
    return 0 if empty?
    error_for_negative
    digits.inject{|sum,x| sum + x}
  end

  def error_for_negative
    raise "Negative numbers not allowed: #{negatives.join(', ')}" if negatives.any?
  end

  def negatives
    digits.select{|x| x < 0}
  end

  def digits
    gsub("\n", delimiter).split(delimiter).map{|x| x.to_i}
  end

  def delimiter
    self[0,2] == '//' ? self[2,1] : ','
  end
end

module StringCalculator
  def add
    return 0 if empty?
    negative_not_present
    digits.inject {|sum, x| sum + x}
  end

  def negative_not_present
    raise "Negatives not allowed: #{@negatives.join(', ')}" if negatives.any?
  end

  def negatives
    @negatives ||= digits.select{|x| x < 0 }
  end

  def digits
    gsub("\n",delimiter).split(delimiter).map { |x| x.to_i }
  end

  def delimiter
    @delimiter ||= self[0,2] == '//' ? self[2,1] : ','
  end
end

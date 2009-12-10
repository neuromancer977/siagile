module StringCalculator
  def total
    return 0 if empty?
    negative_not_allowed
    digits.inject{|sum,x| sum + x}
  end

private
  def negatives
    digits.select{|x| x < 0}
  end

  def negative_not_allowed
    raise "#{negatives.join(', ')}" if negatives.any?
  end

  def delimiter
    self[0,2] == '//' ? self[2,1] : ','
  end

  def digits
    gsub("\n",delimiter).split(delimiter).map{|x| x.to_i}
  end
end

class String
  include StringCalculator
end

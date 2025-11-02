/*
Реализация метода equals() должна следовать следующим соглашениям:

1. equals() задает отношение эквивалентности, т.е. обладает свойствами:
   - рефлексивность: x.equals(x) == true для любого x
   - симметричность: если x.equals(y) == true, то y.equals(x) == true
   - транзитивность: если x.equals(y) == true и y.equals(z) == true, то x.equals(z) == true

2. Для любых объектов x и y x.equals(y) всегда возвращает одно и то же значение при условии, что
объекты x и y не менялись

3. Для любого не null объекта x x.equals(null) == false
 */


class ComplexNumber {
    public double re;
    public double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    //Сравниваем значения по определению равенства комплексных чисел (оно является отношением эквивалентности)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        ComplexNumber num = (ComplexNumber)obj;
        return (re == num.re) && (im == num.im);
    }

    //Вместе с equals() переопределяем hashCode()
    @Override
    public int hashCode() {
        return java.util.Objects.hash(re, im);
    }
}
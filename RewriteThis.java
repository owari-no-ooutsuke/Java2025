class A {
    int a;
    int b;
    int c;
    int z;

    public A() {
        z = 1;
    }

    public A(int a) {
        this(); //z = 1
        this.a = a;
    }

    public A(int a, int b) {
        this(a); //this.a = a; z = 1
        this.b = b;
    }

    public A(int a, int b, int c) {
        this(a, b); //this.a = a; this.b = b; z = 1
        this.c = c;
    }
}
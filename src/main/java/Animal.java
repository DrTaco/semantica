public class Animal implements Comparable<Animal>{
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Animal o) {
        if(age==o.age)
            return 0;
        else if(age>o.age)
            return 1;
        else
            return -1;
    }

    public static class Builder{
        private String name;
        private int age;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Animal build(){
            return new Animal(this.name, this.age);
        }
    }
}

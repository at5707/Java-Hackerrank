    import java.lang.reflect.*;
    import java.util.*;

    class Student{
        private String name;
        private String id;
        private String email;

        public String getName() {
            return name;
        }
        public String getId() {
            return id;
        }
        public String getEmail() {
            return email;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setId(String id) {
            this.id = id;
        }
        public void setEmail(String email) {
            this.email = email;
        }
    }

    class JavaReflectionAttributes {

        public static void main(String[] args){
            Class student = ~~Complete this line~~;
            Method[] methods = ~~Complete this line~~;

            ArrayList<String> methodList = new ArrayList<>();
            for(~~Complete this line~~){
                methodList.add(~~Complete this line~~);
            }
            Collections.sort(methodList);
            for(String name: methodList){
                System.out.println(name);
            }
        }

    }

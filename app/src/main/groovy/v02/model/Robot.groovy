package v02.model

class Robot {
    void move(Direction dir) {
        println "robot moved $dir"
    }

    void say(String greeting, String name) {
        println "say $greeting, $name"
    }
}
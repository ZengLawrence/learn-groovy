import groovy.transform.TupleConstructor

def a = [1]

def clone = a.clone()

assert a == clone

static def copy(Object original) {
    original.clone()
}

@TupleConstructor
class MyClass {
    String name
}

//def original = new MyClass('John')
def original = [name: 'john']
assert original.collectEntries(Closure.IDENTITY) == original
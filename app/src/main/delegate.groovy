def doTask(final Closure body) {
    def config = [
            version : 1,
            name : 'config'
    ]
    //body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
}

doTask {
    println "${name} is ${version}"
}

doTask {
    version = 2
    println "${name} is ${version}"
}
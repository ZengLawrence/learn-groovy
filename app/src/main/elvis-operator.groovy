class Config {
    List pools
    String pool
}

def printPools(config) {
    def pools = config.pools?.collect { it.pool } ?: [config.pool]
    pools.each { println it }
}

{
    def config = new Config()
    config.pool = 'na-5x'
    printPools(config)
}

{
    def config = new Config()
    config.pools = [
            [pool: 'na-1z'],
            [pool: 'na-2z']
    ]
    printPools(config)
}
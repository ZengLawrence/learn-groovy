import groovy.ant.AntBuilder

def cmd = "(ls -l || echo 'command failed')"
def script = ['bash', '-c', cmd]
def proc = script.execute()
proc.consumeProcessOutputStream(System.out)
def exitCode = proc.waitFor()

assert exitCode == 0
println "Exit code: ${exitCode}"

// use AntBuilder
def ant = new AntBuilder()
ant.echo('Hello, Ant Builder!')

ant.exec(executable: 'bash', resultproperty: 'my.cmd.exitCode') {
    arg(value: '-c')
    arg(value: cmd)
}
ant.echo('Exit code is ${my.cmd.exitCode}')
// getting exit code from project property
def cmdExitCode = ant.project.getProperty('my.cmd.exitCode')
println "Exit code: ${cmdExitCode}"

println "Project properteis: ${ant.project.properties}"

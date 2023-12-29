package v02.integration

import v02.model.Robot

abstract class RobotBaseScript extends Script {
    @Delegate @Lazy Robot robot = this.binding.robot
}

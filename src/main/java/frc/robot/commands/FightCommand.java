package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motors;

public class FightCommand extends CommandBase {
    private final Motors motors;

    public FightCommand(Motors m) {
        motors = m;
    }

    @Override
    public void execute() {
        motors.setMotorSpeed(0, -0.05);
    }

    @Override
    public void end(boolean interrupted) {
        motors.setMotorSpeed(0, 0);
    }
}

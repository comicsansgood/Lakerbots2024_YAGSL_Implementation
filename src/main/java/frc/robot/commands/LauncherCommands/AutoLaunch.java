package frc.robot.commands.LauncherCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.commands.FeederCommands.FeederGo;
import frc.robot.commands.FeederCommands.FeederStop;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class AutoLaunch extends SequentialCommandGroup {

    public AutoLaunch( 
        LauncherSubsystem launcher,
        FeederSubsystem feeder,
        double theta
        )
    {
        addCommands(
            new LauncherAim(launcher, theta),
            new LauncherGo(launcher),
            new FeederGo(feeder, -0.6),
            new WaitCommand(.65),
            new LauncherStop(launcher),
            new FeederStop(feeder)
        );
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}

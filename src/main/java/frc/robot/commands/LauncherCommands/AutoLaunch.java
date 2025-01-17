package frc.robot.commands.LauncherCommands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.FeederCommands.FeederGo;
import frc.robot.commands.FeederCommands.FeederStop;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.LauncherSubsystem;

public class AutoLaunch extends SequentialCommandGroup {

    public AutoLaunch(LauncherSubsystem launcher, FeederSubsystem feeder, double theta){
        addCommands(
            new LauncherGo(launcher),
            new LauncherAim(launcher, theta),
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

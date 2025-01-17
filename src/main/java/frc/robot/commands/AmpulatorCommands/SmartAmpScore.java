package frc.robot.commands.AmpulatorCommands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.LauncherCommands.LauncherAim;
import frc.robot.commands.LauncherCommands.LauncherSet;
import frc.robot.Constants;
import frc.robot.commands.ElevatorCommands.ElevatorGoToPosition;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.AmpulatorSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;

public class SmartAmpScore extends SequentialCommandGroup {

  public SmartAmpScore(LauncherSubsystem launcher,ElevatorSubsystem m_Elevator, AmpulatorSubsystem ampulator) {
    addCommands(
      new LauncherSet(launcher, -.7, -.9),
      new LauncherAim(launcher, Constants.LauncherConstants.launcherAngleAmpScore),
      new WaitCommand(.2),
      new ElevatorGoToPosition(m_Elevator, -30),
      new AmpulatorOut(ampulator)
    );  
  }

}
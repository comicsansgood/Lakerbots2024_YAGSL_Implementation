package frc.robot.commands.LauncherCommands;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class LauncherIncrement extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final LauncherSubsystem m_launcher;
  private double increment;

  public LauncherIncrement(LauncherSubsystem launcher, double increment) {
    this.increment = increment;
    m_launcher = launcher;
    addRequirements(m_launcher);
  }

  @Override
  public void initialize() {
    m_launcher.launcherIncrement(increment);

  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}

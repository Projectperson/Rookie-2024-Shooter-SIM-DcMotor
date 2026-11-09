package frc.robot.Subsystems.Shooter;

import org.littletonrobotics.junction.AutoLog;

public interface ShooterIO {
    
    @AutoLog
    public class shooterInputs{
        public double velocity = 0.0;
        public double current = 0.0;
        public double voltage = 0.0;
        public double position = 0.0;
        public double setpoint = 0.0;
    }


public default void updateInputs(shooterInputs inputs){}

public default void setVelocity(double velocity){}

public default void setVoltage(double voltage){}

}



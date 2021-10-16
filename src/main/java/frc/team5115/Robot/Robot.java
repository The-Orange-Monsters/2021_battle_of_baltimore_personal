package frc.team5115.Robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot {
    private Command autoCommand;
    private RobotContainer robotContainer;

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {
        autoCommand = robotContainer.getAutonomousCommand();
        
/*
        // schedule the autonomous command (example)
        if (autoCommand != null) {
            robotContainer.locationator.setAngleAndLocation(90, startingConfiguration.getX(), 30);
            autoCommand.schedule();
            System.out.println("Scheduling auto command");
        } else System.out.println("Boy you better fix this bitch-ass problem your auto code done broke you a little shit cuz you code sum dumb shit you dumbass it caint find no code.");
        //CommandScheduler.getInstance().enable();
    }
    */
}


        /**
         * This function is called periodically during autonomous.
         */

        public void autonomousPeriodic() {
            robotContainer.getAutonomousCommand();
        }

        public void teleopInit () {
            // This makes sure that the autonomous stops running when
            // teleop starts running. If you want the autonomous to
            // continue until interrupted by another command, remove
            // this line or comment it out.
            if (autoCommand != null) {
                autoCommand.cancel();
            }

            robotContainer.startTeleop();
        }


        /**
         * This function is called periodically during operator control.
         */

        public void teleopPeriodic () {
        }


        public void testInit () {
            // Cancels all running commands at the start of test mode.
            CommandScheduler.getInstance().cancelAll();
        }

        /**
         * This function is called periodically during test mode.
         */

        public void testPeriodic () {
        }

        public void practiceInit(){
            if (autoCommand != null) {
                autoCommand.cancel();
            }

            robotContainer.startTeleop();
        }

        public void practicePeriodic(){}
    }

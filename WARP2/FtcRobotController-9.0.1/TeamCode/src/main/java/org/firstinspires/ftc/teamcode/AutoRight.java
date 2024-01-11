package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="AutoRight", group="Concept")
public class AutoRight extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    RobotMap robotMap = new RobotMap();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robotMap.init(hardwareMap);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();
        robotMap.intakeServo.setPosition(robotMap.INTAKE_GRAB);
        sleep(1800);
        robotMap.wristServo1.setPosition(robotMap.WRIST_UP);
        robotMap.wristServo2.setPosition(robotMap.WRIST_UP);
        sleep(1000);

        robotMap.driveForTime(0.5, 1.45);

        sleep(1000);

        robotMap.wristServo1.setPosition(robotMap.WRIST_STORAGE);
        robotMap.wristServo2.setPosition(robotMap.WRIST_STORAGE);
        sleep(1000);
        robotMap.intakeServo.setPosition(robotMap.INTAKE_RELEASE);
        sleep(1000);
        robotMap.driveForTime(-0.5, 0.15);
        robotMap.intakeServo.setPosition(robotMap.INTAKE_GRAB);
        sleep(1000);
        robotMap.wristServo1.setPosition(robotMap.WRIST_UP);
        robotMap.wristServo2.setPosition(robotMap.WRIST_UP);
        sleep(1000);
        robotMap.driveForTime(-0.5, 0.45);
        sleep(1000);
        robotMap.rotateForTime(-0.5, 1.28);
        sleep(1000);
        robotMap.driveForTime(-0.5, 2.0);
        sleep(1000);
        robotMap.liftForTime(-0.5, 2.6);
        sleep(1000);
        robotMap.wristServo1.setPosition(robotMap.WRIST_SCORING);
        robotMap.wristServo2.setPosition(robotMap.WRIST_SCORING);
        sleep(1000);
        robotMap.driveForTime(0.5, 0.1);
        sleep(1000);
        robotMap.liftForTime(0.5, 0.65);
        sleep(1000);
        robotMap.intakeServo.setPosition(robotMap.INTAKE_RELEASE);
        sleep(1000);
        robotMap.intakeServo.setPosition(robotMap.INTAKE_GRAB);
        sleep(500);
        robotMap.strafeForTime(-0.5, 1.2);
        robotMap.liftForTime(-0.5, 0.65);



        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            //Code
            sleep(30000);
        }
    }
}

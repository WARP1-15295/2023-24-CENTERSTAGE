package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name="TeleOp Control")
//@Disabled
public class TeleOpControl extends OpMode {
    // Declare OpMode members here
    private ElapsedTime elapsedTime = new ElapsedTime();
    RobotMap robotMap = new RobotMap();
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        robotMap.init(hardwareMap);
    }
    @Override
    public void init_loop() {
    }
    public
    @Override
    void start() {
        robotMap.intakeServo.setPosition(robotMap.INTAKE_GRAB);
        robotMap.wristServo1.setPosition(robotMap.WRIST_STORAGE);
        robotMap.wristServo2.setPosition(robotMap.WRIST_STORAGE);
        elapsedTime.reset();
    }
    @Override
    public void loop() {
        //GAMEPAD 1
        double degreesToRads45 = -Math.PI/4;
        double leftStickDeadZone = 0.1;
        double rightStickDeadZone = 0.1;

        double x = gamepad1.left_stick_x * Math.cos(degreesToRads45) + gamepad1.left_stick_y * Math.sin(degreesToRads45);
        double y = -gamepad1.left_stick_y * Math.cos(degreesToRads45) + gamepad1.left_stick_x * Math.sin(degreesToRads45);
        double rotate = gamepad1.right_stick_x;


        if (Math.abs(rotate) > rightStickDeadZone) {
            robotMap.leftFrontDrive.setPower(rotate);
            robotMap.leftBackDrive.setPower(rotate);
            robotMap.rightFrontDrive.setPower(-rotate);
            robotMap.rightBackDrive.setPower(-rotate);
        } else if(Math.abs(x) > leftStickDeadZone || Math.abs(y) > leftStickDeadZone) {
            robotMap.leftFrontDrive.setPower(x);
            robotMap.leftBackDrive.setPower(y);
            robotMap.rightFrontDrive.setPower(y);
            robotMap.rightBackDrive.setPower(x);
        } else {
            robotMap.leftFrontDrive.setPower(0.0);
            robotMap.leftBackDrive.setPower(0.0);
            robotMap.rightFrontDrive.setPower(0.0);
            robotMap.rightBackDrive.setPower(0.0);
        }

        //GAMEPAD 2

        if (gamepad2.left_stick_y < rightStickDeadZone) { // UP
            telemetry.addData("LIFT UP", gamepad2.left_stick_y);
            robotMap.liftMotor1.setPower(gamepad2.left_stick_y);
            robotMap.liftMotor2.setPower(gamepad2.left_stick_y);
            robotMap.reverseLiftMotor.setPower(gamepad2.left_stick_y);
        } else if (gamepad2.left_stick_y > -rightStickDeadZone) { // DOWN
            telemetry.addData("LIFT DOWN", gamepad2.left_stick_y);
            robotMap.liftMotor1.setPower(gamepad2.left_stick_y);
            robotMap.liftMotor2.setPower(gamepad2.left_stick_y);
            robotMap.reverseLiftMotor.setPower(gamepad2.left_stick_y);
        } else { // STAY
            robotMap.liftMotor1.setPower(0);
            robotMap.liftMotor2.setPower(0);
            robotMap.reverseLiftMotor.setPower(0);
        }

        if (gamepad2.a) {
            robotMap.intakeServo.setPosition(robotMap.INTAKE_GRAB);
        } else if (gamepad2.b) {
            robotMap.intakeServo.setPosition(robotMap.INTAKE_RELEASE);
        }

        if (gamepad2.dpad_down) {
            robotMap.wristServo1.setPosition(robotMap.WRIST_SCORING);
            robotMap.wristServo2.setPosition(robotMap.WRIST_SCORING);
        } else if (gamepad2.dpad_up) {
            robotMap.wristServo1.setPosition(robotMap.WRIST_STORAGE);
            robotMap.wristServo2.setPosition(robotMap.WRIST_STORAGE);
        } else if (gamepad2.dpad_right) {
            robotMap.wristServo1.setPosition(robotMap.WRIST_UP);
            robotMap.wristServo2.setPosition(robotMap.WRIST_UP);
        }

    }
    @Override
    public void stop () {
    }
}
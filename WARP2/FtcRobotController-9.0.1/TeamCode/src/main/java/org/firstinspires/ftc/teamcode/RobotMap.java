package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RobotMap {

    public static DcMotor leftFrontDrive = null;
    public static DcMotor rightFrontDrive = null;
    public static DcMotor leftBackDrive = null;
    public static DcMotor rightBackDrive = null;


    public static DcMotor liftMotor1 = null;
    public static DcMotor liftMotor2 = null;
    public static DcMotor reverseLiftMotor = null;


    public static Servo wristServo1 = null;
    public static Servo wristServo2 = null;
    public static Servo intakeServo = null;

    public static final double INTAKE_GRAB = 0.5;
    public static final double INTAKE_RELEASE = 0.0;

    public static final double WRIST_SCORING = 0.7;
    public static final double WRIST_STORAGE = 0.3;
    public static final double WRIST_UP = 0.0;

    HardwareMap hardwareMap = null;
    private ElapsedTime runtime = new ElapsedTime();

    public RobotMap() {
    }

    public void init(HardwareMap hwMap) {
        // Save reference to Hardware map
        hardwareMap = hwMap;

        leftFrontDrive = hardwareMap.get(DcMotor.class, "leftFrontDrive"); // 0
        rightFrontDrive = hardwareMap.get(DcMotor.class, "rightFrontDrive"); // 2
        leftBackDrive = hardwareMap.get(DcMotor.class, "leftBackDrive"); // 1
        rightBackDrive = hardwareMap.get(DcMotor.class, "rightBackDrive"); // 3

        liftMotor1 = hardwareMap.get(DcMotor.class, "liftMotor1"); //3
        liftMotor2 = hardwareMap.get(DcMotor.class, "liftMotor2"); //2
        reverseLiftMotor = hardwareMap.get(DcMotor.class, "reverseLiftMotor"); //2

        wristServo1 = hardwareMap.get(Servo.class, "wristServo1");
        wristServo2 = hardwareMap.get(Servo.class, "wristServo2");
        intakeServo = hardwareMap.get(Servo.class, "intakeServo");

        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);

        liftMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        liftMotor2.setDirection(DcMotorSimple.Direction.FORWARD);
        reverseLiftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        wristServo1.setDirection(Servo.Direction.FORWARD);
        wristServo2.setDirection(Servo.Direction.REVERSE);
        intakeServo.setDirection(Servo.Direction.FORWARD);

        // Reset motor encoders
        leftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        liftMotor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        reverseLiftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        // Set motor default run mode to use encoders
        leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void liftForTime(double power, double seconds) {
        runtime.reset();
        runtime.startTime();

        liftMotor1.setPower(power);
        liftMotor2.setPower(power);
        reverseLiftMotor.setPower(power);
        while (runtime.seconds() <= seconds) {}
        liftMotor1.setPower(0.0);
        liftMotor2.setPower(0.0);
        reverseLiftMotor.setPower(0.0);
    }

    public void driveForTime(double power, double seconds) {
        runtime.reset();
        runtime.startTime();

        leftFrontDrive.setPower(power);
        rightFrontDrive.setPower(power);
        leftBackDrive.setPower(power);
        rightBackDrive.setPower(power);
        while (runtime.seconds() <= seconds) {}
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(0.0);
        leftBackDrive.setPower(0.0);
        rightBackDrive.setPower(0.0);
    }

    public void strafeForTime(double power, double seconds) {
        runtime.reset();
        runtime.startTime();

        leftFrontDrive.setPower(power);
        rightFrontDrive.setPower(-power);
        leftBackDrive.setPower(-power);
        rightBackDrive.setPower(power);
        while (runtime.seconds() <= seconds) {}
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(0.0);
        leftBackDrive.setPower(0.0);
        rightBackDrive.setPower(0.0);
    }

    public void rotateForTime(double power, double seconds) {
        runtime.reset();
        runtime.startTime();

        leftFrontDrive.setPower(power);
        rightFrontDrive.setPower(-power);
        leftBackDrive.setPower(power);
        rightBackDrive.setPower(-power);
        while (runtime.seconds() <= seconds) {}
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(0.0);
        leftBackDrive.setPower(0.0);
        rightBackDrive.setPower(0.0);
    }
}
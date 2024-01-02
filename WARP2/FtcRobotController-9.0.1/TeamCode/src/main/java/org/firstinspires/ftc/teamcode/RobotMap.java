package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RobotMap {

    /* Public OpMode members. */
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

    public static final double INTAKE_GRAB = 1.0; //CHANGE
    public static final double INTAKE_RELEASE = 0.0; //CHANGE
    public static final double WRIST_SCORING = 1.0; //CHANGE
    public static final double WRIST_STORAGE = 0.0; //CHANGE


    public static final int WHEEL_DIAMETER = 101; //VEX 4 INCH
    public static final double MILLIMETER_TO_INCHES_CONSTANT = 25.4;

    public static final double WHEEL_CIRCUMFERENCE_INCHES = (Math.PI * WHEEL_DIAMETER) / MILLIMETER_TO_INCHES_CONSTANT; // ~ 11.13 in. IN 1120 ticks (1 Rev)

    /* local OpMode members. */
    HardwareMap hardwareMap = null;
    private ElapsedTime runtime = new ElapsedTime();

    /* Constructor */
    public RobotMap() {
    }

    /* Initialize standard Hardware interfaces */
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
}
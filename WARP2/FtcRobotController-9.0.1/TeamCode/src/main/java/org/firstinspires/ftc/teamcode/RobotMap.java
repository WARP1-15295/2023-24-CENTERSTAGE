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
    public static Dcmotor rightBackDrive = null;

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

        leftFrontDrive  = hardwareMap.get(DcMotor.class, "leftFrontDrive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "rightFrontDrive");
        leftBackDrive = hardwareMap.get(DcMotor.class, "leftBackDrive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "rightBackDrive");

        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);

        // Reset motor encoders
        leftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCONDER);


        // Set motor default run mode to use encoders
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public int encoderConvert(double inches) {
        //The RUT_TO_POSITION function of DcMotor requires an int to be passed in. We cast the answer of this line down to an int to satisfy this.
        int units = (int) Math.round(COUNTS_PER_INCH * inches);
        return units;
    }

}
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "ParkOnly_RedTop", group = "FreightBot")
public class ParkOnlyRedTop extends LinearOpMode {
    DcMotor backLeft, backRight, frontLeft, frontRight;
    final long TURN_SLEEP_TIME = 875;

    @Override
    public void runOpMode() throws InterruptedException {
        backLeft = hardwareMap.dcMotor.get("back_left_motor");
        backRight = hardwareMap.dcMotor.get("back_right_motor");
        frontLeft = hardwareMap.dcMotor.get("front_left_motor");
        frontRight = hardwareMap.dcMotor.get("front_right_motor");

        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        parkInWarehouse();
    }

    public void parkInWarehouse() {
        driveForward(500);
        turnRight();
        driveForward(1000);
        turnLeft();
        driveForward(500);
    }

    // TUrns to much
    public void turnLeft() {
        backLeft.setPower(-1);
        backRight.setPower(1);
        frontLeft.setPower(-1);
        frontRight.setPower(1);

        sleep(TURN_SLEEP_TIME);

        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
    }

    public void turnRight() {
        backLeft.setPower(1);
        backRight.setPower(-1);
        frontLeft.setPower(1);
        frontRight.setPower(-1);

        sleep(TURN_SLEEP_TIME);

        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
    }

    public void driveForward(long sleepTime) {
        backLeft.setPower(1);
        backRight.setPower(1);
        frontLeft.setPower(1);
        frontRight.setPower(1);

        sleep(sleepTime);

        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
    }

    public void driveReverse(long sleepTime) {
        backLeft.setPower(-1);
        backRight.setPower(-1);
        frontLeft.setPower(-1);
        frontRight.setPower(-1);

        sleep(sleepTime);

        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);
    }
}

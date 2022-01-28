package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public interface AutoTemplate {
    void drive(int leftPos, int rightPos, int power);
    void turnToCarousel();
    void placeFreight();
    void goToWarehouse();
}

# lab01# Lab 1 – Basic JUnit 4

**Author:** Ettory Souza  
**Course:** CSE 2102 – Software Engineering  
**Professor:** Bradford  

---

## Overview
This lab introduces basic **JUnit 4 testing** and project organization using GitHub Codespaces.  
We implemented two interfaces (`Gasoline` and `Electric`) and a `HybridVehicle` class that supports both.  
A `CarRunner` class demonstrates sample calculations, and unit tests verify correctness.

---

## Project Structure
c/ → main code
Gasoline.java
Electric.java
HybridVehicle.java
CarRunner.java

u/ → tests
HybridVehicleTest.java

junit-4.13.2.jar, hamcrest-core-1.3.jar → JUnit libraries
## How to Build
```bash
javac -cp "junit-4.13.2.jar:hamcrest-core-1.3.jar:." -d . ./c/c/*.java ./u/*.java

## How to Run 
java -cp ".:junit-4.13.2.jar:hamcrest-core-1.3.jar" c.CarRunner

## Description

In this lab I built two interfaces (Gasoline, Electric) and one class (HybridVehicle) that implements both.
The class calculates gas MPG, electric MPGe, and the hybrid average.
I also wrote a driver program (CarRunner) to demonstrate the calculations, and JUnit tests (HybridVehicleTest) to automatically check results.

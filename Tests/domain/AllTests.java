package domain;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.concurrent.Callable;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import static org.junit.Assert.*;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CirkelTest.class, LijnStukTest.class, RechthoekTest.class})
public class AllTests {}

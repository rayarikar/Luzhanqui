package MessageParserTest;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import MessageParser.RefereeToPlayer;

public class RefereeToPlayerTest {

	@Test
	public void Init1() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 1 time/move 12)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void Init2() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 1 time/move 12.34)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void Init3() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 2 time/move 12)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void Init4() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 2 time/move 12.34)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void Init5() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 3 time/move 12)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void Init6() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 1 time/move -12)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void Init7() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 1 time/move 0)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void Init8() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 1 time\\move 12)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void Init9() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 1 time 0)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void Init10() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init    1   time/move    12)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void Init11() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 1 time/move)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void Init12() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init time/move 12)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void Init13() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 1 time/move 0.0)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void Init14() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 1 time/move 0.00)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void Init15() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(init 1 time/move 00.0)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void end1() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(end 0)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void end2() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(end 1)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void end3() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(end 2)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void end4() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(   end     1  )";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void end5() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(end 3)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void end6() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(end )";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void illegal1() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(illegal )";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void illegal2() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(illegal (A1 A2))";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void illegal3() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(illegal (A13 B1))";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void illegal4() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(illegal (A1 B13))";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void illegal5() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(illegal A1 A2)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void illegal6() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(illegal (A1 A2)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void illegal7() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(illegal (A1))";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void illegal8() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(illegal (A1 A2)))";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void go1() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(go 1)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void go2() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(go 2)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void go3() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(go )";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void go4() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(go 3)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void go5() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(go 0)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void outcome1() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(outcome (A1 A2))";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void outcome2() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(outcome <(A1 A2))";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void outcome3() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(outcome >(A1 A2))";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void outcome4() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(outcome =(A1 A2))";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void outcome5() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(outcome <(A1 A2)))";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void outcome6() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(outcome (A1 A13))";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void outcome7() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(outcome !(A1 A2))";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void outcome8() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(outcome A1 A2)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void flag1() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(flag 1 A1)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void flag2() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(flag 2 A1)";
		Assert.assertEquals(r.processRefereeMessage(message), true);
	}
	
	@Test
	public void flag3() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(flag 1)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void flag4() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(flag 0 A1)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
	
	@Test
	public void flag5() {
		RefereeToPlayer r = new RefereeToPlayer();
		String message = "(flag 1 A13)";
		Assert.assertEquals(r.processRefereeMessage(message), false);
	}
}

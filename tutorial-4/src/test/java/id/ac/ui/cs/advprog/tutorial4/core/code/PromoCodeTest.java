package id.ac.ui.cs.advprog.tutorial4.core.code;

import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import static org.mockito.Mockito.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PromoCodeTest {

    private Class<?> promoCodeClass;

    @Mock
    Item item;

    @BeforeEach
    public void setUp() throws Exception {
        promoCodeClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.core.code.PromoCode");
    }

    @Test
    public void testPromoCodeIsAbstractClass() {
        assertTrue(Modifier.isAbstract(promoCodeClass.getModifiers()));
    }

    @Test
    public void testPromoCodeIsARedeemCode() {
        Collection<Type> interfaces = Arrays.asList(promoCodeClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.core.code.RedeemCode")));
    }

    @Test
    public void testPromoCodeOverrideGetCodeMethod() throws Exception {
        Method getCode = promoCodeClass.getDeclaredMethod("getCode");

        assertTrue(Modifier.isPublic(getCode.getModifiers()));
        assertEquals(0, getCode.getParameterCount());
    }

    @Test
    public void testPromoCodeOverrideIsRedeemedMethod() throws Exception {
        Method isRedeemed = promoCodeClass.getDeclaredMethod("isRedeemed");

        assertTrue(Modifier.isPublic(isRedeemed.getModifiers()));
        assertEquals(0, isRedeemed.getParameterCount());
    }

    @Test
    public void testPromoCodeOverrideRedeemedMethod() throws Exception {
        Method redeem = promoCodeClass.getDeclaredMethod("redeem");

        assertTrue(Modifier.isPublic(redeem.getModifiers()));
        assertEquals(0, redeem.getParameterCount());
    }

    @Test
    public void TestPromoCodeGetCodeReturnString(){
        PromoCode promoCodeMock = Mockito.mock(
                PromoCode.class,
                Mockito.withSettings()
                        .useConstructor("code", item, 0.0 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertTrue(promoCodeMock.getCode().getClass().equals(String.class));
    }


    @Test
    public void TestPromoCodeIsRedeemedReturnBoolean() throws Exception{
        Set<String> set = new HashSet<>();
        set.add("true");
        set.add("false");
        PromoCode promoCodeMock = Mockito.mock(
                PromoCode.class,
                Mockito.withSettings()
                        .useConstructor("code",item, 0.0 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        String s = Boolean.toString(promoCodeMock.isRedeemed());
        assertTrue(set.contains(s));
    }







}

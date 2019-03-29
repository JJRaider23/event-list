package strasburg.event;

import java.util.EventObject;

public class FooEvent extends EventObject
{
    FooEvent(Object source)
    {
        super(source);
    }
}
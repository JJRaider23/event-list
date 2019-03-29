package strasburg.event;

import java.util.EventListener;

public interface FooEventListener extends EventListener
{
    void foo(FooEvent event);
}
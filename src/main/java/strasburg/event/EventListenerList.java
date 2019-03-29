package strasburg.event;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;


public class EventListenerList<T extends EventListener>
{
    private List<T> listenerList;

    public EventListenerList()
    {
        listenerList = new ArrayList<>();
    }


    public void addEventListener(final T listener)
    {
        if(!listenerList.contains(listener))
        {
            listenerList.add(listener);
        }
    }


    public void removeEventListener(final T listener)
    {
        listenerList.remove(listener);
    }


    public <E extends EventObject> void fireEventListener(final E event,
        final String methodName,
        final Class<E> argumentType) throws NoSuchMethodException
    {
        Method method = null;

        for(T listener : listenerList)
        {
            method = listener.getClass().getMethod(methodName, argumentType);
            try
            {
                method.invoke(listener, event);
            }
            catch(Exception e)
            {
                // TODO - do something, maybe
            }
        }
    }
}
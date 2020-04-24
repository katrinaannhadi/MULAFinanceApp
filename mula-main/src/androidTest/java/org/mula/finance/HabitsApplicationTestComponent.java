/* Mula */

package org.mula.finance;

import org.mula.androidbase.AppContextModule;
import org.mula.finance.core.AppScope;
import org.mula.finance.core.tasks.SingleThreadTaskRunner;
import org.mula.finance.core.tasks.TaskRunner;

import dagger.*;

@AppScope
@Component(modules = {
    AppContextModule.class,
    HabitsModule.class,
    SingleThreadModule.class,
})
public interface HabitsApplicationTestComponent
    extends HabitsApplicationComponent
{

}

@Module
class SingleThreadModule
{
    @Provides
    @AppScope
    static TaskRunner provideTaskRunner()
    {
        return new SingleThreadTaskRunner();
    }
}

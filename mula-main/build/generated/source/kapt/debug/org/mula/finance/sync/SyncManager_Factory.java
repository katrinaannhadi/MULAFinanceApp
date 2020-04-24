package org.mula.finance.sync;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.mula.androidbase.SSLContextProvider;
import org.mula.finance.core.commands.CommandParser;
import org.mula.finance.core.commands.CommandRunner;
import org.mula.finance.core.preferences.Preferences;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SyncManager_Factory implements Factory<SyncManager> {
  private final Provider<SSLContextProvider> sslProvider;

  private final Provider<Preferences> prefsProvider;

  private final Provider<CommandRunner> commandRunnerProvider;

  private final Provider<CommandParser> commandParserProvider;

  public SyncManager_Factory(Provider<SSLContextProvider> sslProvider,
      Provider<Preferences> prefsProvider, Provider<CommandRunner> commandRunnerProvider,
      Provider<CommandParser> commandParserProvider) {
    this.sslProvider = sslProvider;
    this.prefsProvider = prefsProvider;
    this.commandRunnerProvider = commandRunnerProvider;
    this.commandParserProvider = commandParserProvider;
  }

  @Override
  public SyncManager get() {
    return newInstance(sslProvider.get(), prefsProvider.get(), commandRunnerProvider.get(), commandParserProvider.get());
  }

  public static SyncManager_Factory create(Provider<SSLContextProvider> sslProvider,
      Provider<Preferences> prefsProvider, Provider<CommandRunner> commandRunnerProvider,
      Provider<CommandParser> commandParserProvider) {
    return new SyncManager_Factory(sslProvider, prefsProvider, commandRunnerProvider, commandParserProvider);
  }

  public static SyncManager newInstance(SSLContextProvider sslProvider, Preferences prefs,
      CommandRunner commandRunner, CommandParser commandParser) {
    return new SyncManager(sslProvider, prefs, commandRunner, commandParser);
  }
}

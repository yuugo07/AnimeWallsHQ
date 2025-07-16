package com.aniwallshq.di;

import com.aniwallshq.data.local.AppDatabase;
import com.aniwallshq.data.local.dao.WallpaperDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AppModule_ProvideWallpaperDaoFactory implements Factory<WallpaperDao> {
  private final Provider<AppDatabase> appDatabaseProvider;

  public AppModule_ProvideWallpaperDaoFactory(Provider<AppDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public WallpaperDao get() {
    return provideWallpaperDao(appDatabaseProvider.get());
  }

  public static AppModule_ProvideWallpaperDaoFactory create(
      Provider<AppDatabase> appDatabaseProvider) {
    return new AppModule_ProvideWallpaperDaoFactory(appDatabaseProvider);
  }

  public static WallpaperDao provideWallpaperDao(AppDatabase appDatabase) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideWallpaperDao(appDatabase));
  }
}

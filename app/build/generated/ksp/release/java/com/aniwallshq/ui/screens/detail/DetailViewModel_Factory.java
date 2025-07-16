package com.aniwallshq.ui.screens.detail;

import androidx.lifecycle.SavedStateHandle;
import com.aniwallshq.data.WallpaperRepository;
import com.aniwallshq.util.Downloader;
import com.aniwallshq.util.WallpaperSetter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class DetailViewModel_Factory implements Factory<DetailViewModel> {
  private final Provider<WallpaperRepository> repositoryProvider;

  private final Provider<Downloader> downloaderProvider;

  private final Provider<WallpaperSetter> wallpaperSetterProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public DetailViewModel_Factory(Provider<WallpaperRepository> repositoryProvider,
      Provider<Downloader> downloaderProvider, Provider<WallpaperSetter> wallpaperSetterProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.repositoryProvider = repositoryProvider;
    this.downloaderProvider = downloaderProvider;
    this.wallpaperSetterProvider = wallpaperSetterProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public DetailViewModel get() {
    return newInstance(repositoryProvider.get(), downloaderProvider.get(), wallpaperSetterProvider.get(), savedStateHandleProvider.get());
  }

  public static DetailViewModel_Factory create(Provider<WallpaperRepository> repositoryProvider,
      Provider<Downloader> downloaderProvider, Provider<WallpaperSetter> wallpaperSetterProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new DetailViewModel_Factory(repositoryProvider, downloaderProvider, wallpaperSetterProvider, savedStateHandleProvider);
  }

  public static DetailViewModel newInstance(WallpaperRepository repository, Downloader downloader,
      WallpaperSetter wallpaperSetter, SavedStateHandle savedStateHandle) {
    return new DetailViewModel(repository, downloader, wallpaperSetter, savedStateHandle);
  }
}

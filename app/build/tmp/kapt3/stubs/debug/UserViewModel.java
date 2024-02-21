
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\f\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"LUserViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/catourneandroid/repository/UserRepository;", "(Lcom/example/catourneandroid/repository/UserRepository;)V", "_allUsers", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/catourneandroid/database/entity/UserEntity;", "_user", "allUsers", "Landroidx/lifecycle/LiveData;", "getAllUsers", "()Landroidx/lifecycle/LiveData;", "user", "getUser", "()Landroidx/lifecycle/MutableLiveData;", "deleteUsers", "", "getUserById", "userId", "", "getUserByIdTeam", "teamId", "insertUser", "Companion", "app_debug"})
@kotlin.Suppress(names = {"UNCHECKED_CAST"})
public final class UserViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.catourneandroid.repository.UserRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.catourneandroid.database.entity.UserEntity>> _allUsers;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.catourneandroid.database.entity.UserEntity> _user;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.catourneandroid.database.entity.UserEntity>> allUsers = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.catourneandroid.database.entity.UserEntity> user = null;
    @org.jetbrains.annotations.NotNull()
    public static final UserViewModel.Companion Companion = null;
    
    public UserViewModel(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.repository.UserRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.catourneandroid.database.entity.UserEntity>> getAllUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.catourneandroid.database.entity.UserEntity> getUser() {
        return null;
    }
    
    public final void getAllUsers() {
    }
    
    public final void getUserById(int userId) {
    }
    
    public final void getUserByIdTeam(int teamId) {
    }
    
    public final void deleteUsers() {
    }
    
    public final void insertUser(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.entity.UserEntity user) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"LUserViewModel$Companion;", "", "()V", "provideFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.ViewModelProvider.Factory provideFactory() {
            return null;
        }
    }
}
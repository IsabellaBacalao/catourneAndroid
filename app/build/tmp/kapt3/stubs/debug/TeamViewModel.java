
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\rJ\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"LTeamViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/catourneandroid/repository/TeamRepository;", "(Lcom/example/catourneandroid/repository/TeamRepository;)V", "_allTeams", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/catourneandroid/database/entity/TeamEntity;", "allTeams", "Landroidx/lifecycle/LiveData;", "getAllTeams", "()Landroidx/lifecycle/LiveData;", "", "getTeamById", "teamId", "", "insertTeam", "team", "Companion", "app_debug"})
@kotlin.Suppress(names = {"UNCHECKED_CAST"})
public final class TeamViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.catourneandroid.repository.TeamRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.catourneandroid.database.entity.TeamEntity>> _allTeams;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.catourneandroid.database.entity.TeamEntity>> allTeams = null;
    @org.jetbrains.annotations.NotNull()
    public static final TeamViewModel.Companion Companion = null;
    
    public TeamViewModel(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.repository.TeamRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.catourneandroid.database.entity.TeamEntity>> getAllTeams() {
        return null;
    }
    
    public final void getAllTeams() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.catourneandroid.database.entity.TeamEntity> getTeamById(int teamId) {
        return null;
    }
    
    public final void insertTeam(@org.jetbrains.annotations.NotNull()
    com.example.catourneandroid.database.entity.TeamEntity team) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"LTeamViewModel$Companion;", "", "()V", "provideFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "app_debug"})
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
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.catourneandroid.database.MyDatabase
import com.example.catourneandroid.database.entity.TeamEntity
import com.example.catourneandroid.repository.TeamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class TeamViewModel(private val repository: TeamRepository) : ViewModel() {

    // LiveData to observe changes in the list of teams
    private var _allTeams = MutableLiveData<List<TeamEntity>>()
    val allTeams: LiveData<List<TeamEntity>> = _allTeams

    fun getAllTeams() {
        viewModelScope.launch{
            val results = repository.getAllTeams()
            _allTeams.value = results
        }
    }

    fun getTeamById(teamId: Int): LiveData<TeamEntity?> {
        val teamLiveData = MutableLiveData<TeamEntity?>()

        viewModelScope.launch {
            val teams = _allTeams.value
            val team = teams?.find { it.idTeam == teamId }
            teamLiveData.value = team
        }

        return teamLiveData
    }

    // Function to insert a new team
    fun insertTeam(team: TeamEntity) {
        viewModelScope.launch(context = Dispatchers.IO) {
            //Check if the team already exist
            val existingTeam = repository.getTeamById(team.idTeam)
            if (existingTeam == null) {
                repository.insertTeam(team)
            }
        }
    }

    fun updateTeam(team: TeamEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTeamById(team.idTeam)?.let {
                val updatedTeam = it.copy(positionTeam = team.positionTeam)
                repository.updateTeam(updatedTeam)
            } ?: run {
                repository.insertTeam(team)
            }
        }
    }

    companion object {
        fun provideFactory() : ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras
                ): T {
                    val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                    // get instance database
                    val teamDao = MyDatabase.getDatabase(application.applicationContext).teamDao()
                    // teamDao
                    val repository = TeamRepository(teamDao)
                    return TeamViewModel(repository = repository) as T
                }
            }
        }

    }



}

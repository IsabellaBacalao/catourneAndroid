import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.catourneandroid.database.MyDatabase
import com.example.catourneandroid.database.entity.UserEntity
import com.example.catourneandroid.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private var _allUsers = MutableLiveData<List<UserEntity>>()
    private var _user = MutableLiveData<UserEntity?>()

    val allUsers: LiveData<List<UserEntity>> = _allUsers

    fun getAllUsers() {
        viewModelScope.launch {
            val results = repository.getAllUsers()
            _allUsers.value = results
        }
    }

    fun getUserById(userId: Int) {
        viewModelScope.launch {
            val user = repository.getUserById(userId)
            _user.value = user
        }
    }

    fun getUserByIdTeam(teamId: Int) {
        viewModelScope.launch {
            val user = repository.getUserByIdTeam(teamId)
            _user.value = user
        }
    }

    fun getUsersByPosition(positionUser: Int) {
        viewModelScope.launch {
            val result = repository.getUsersByPosition(positionUser)
            _allUsers.value = result
        }
    }

    fun updateScore(user: UserEntity) {
        viewModelScope.launch {
            repository.updateScore(user)
        }
    }

    fun updatePositionUser(user: UserEntity) {
        viewModelScope.launch {
            repository.updatePositionUser(user)
        }
    }

    fun updateIdTeamByUserId(user: UserEntity) {
        viewModelScope.launch {
            repository.updateIdTeamByUserId(user)
        }
    }

    fun deleteUsers() {
        viewModelScope.launch {
            repository.deleteAllUsers()
        }
    }

    fun insertUser(user: UserEntity) {
        viewModelScope.launch(context = Dispatchers.IO)  {
            // Check if the user already exists
            val existingUser = repository.getUserById(user.idTeam)
            if (existingUser == null) {
                repository.insertUser(user)
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
                    val userDao = MyDatabase.getDatabase(application.applicationContext).userDao()
                    // userDao
                    val repository = UserRepository(userDao)
                    return UserViewModel(repository = repository) as T
                }
            }
        }

    }
}

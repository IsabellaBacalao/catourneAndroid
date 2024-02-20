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
    val allUsers: LiveData<List<UserEntity>> = _allUsers

    fun getAllUsers() {
        viewModelScope.launch{
            val results = repository.getAllUsers()
            _allUsers.value = results
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

package com.kuluruvineeth.expensetracker.presentation.welcome_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuluruvineeth.expensetracker.data.local.entity.AccountDto
import com.kuluruvineeth.expensetracker.domain.model.CurrencyModel
import com.kuluruvineeth.expensetracker.domain.usecase.GetCurrencyUseCase
import com.kuluruvineeth.expensetracker.domain.usecase.write_database.InsertAccountsUseCase
import com.kuluruvineeth.expensetracker.domain.usecase.write_datastore.EditCurrencyUseCase
import com.kuluruvineeth.expensetracker.domain.usecase.write_datastore.EditOnBoardingUseCase
import com.kuluruvineeth.expensetracker.presentation.home_screen.Account
import com.kuluruvineeth.expensetracker.presentation.welcome_screen.components.OnBoardingPage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val editOnBoardingUseCase: EditOnBoardingUseCase,
    private val editCurrencyUseCase: EditCurrencyUseCase,
    private val insertAccountsUseCase: InsertAccountsUseCase,
    getCurrencyUseCase: GetCurrencyUseCase
) : ViewModel() {

    var countryCurrencies = mutableStateOf(emptyMap<Char, List<CurrencyModel>>())
        private set

    init {
        countryCurrencies.value = getCurrencyUseCase().groupBy { it.country[0] }
    }

    val listOfPages: State<List<OnBoardingPage>> = mutableStateOf(listOf(
        OnBoardingPage.FirstPage,
        OnBoardingPage.SecondPage,
        OnBoardingPage.ThirdPage
    ))

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(IO) {
            editOnBoardingUseCase(completed = completed)
        }
    }

    fun saveCurrency(currency: String) {
        viewModelScope.launch(IO) {
            editCurrencyUseCase(currency)
        }
    }

    fun createAccounts() {
        viewModelScope.launch(IO) {
            insertAccountsUseCase.invoke(
                listOf(
                    AccountDto(1, Account.CASH.title, 0.0, 0.0, 0.0),
                    AccountDto(2, Account.BANK.title, 0.0, 0.0, 0.0),
                    AccountDto(3, Account.CARD.title, 0.0, 0.0, 0.0)
                )
            )
        }
    }
}
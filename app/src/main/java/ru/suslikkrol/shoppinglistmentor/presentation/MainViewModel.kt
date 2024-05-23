package ru.suslikkrol.shoppinglistmentor.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.suslikkrol.shoppinglistmentor.data.ShopListRepositoryImpl
import ru.suslikkrol.shoppinglistmentor.domain.DeleteShopItemUseCase
import ru.suslikkrol.shoppinglistmentor.domain.EditShopItemUseCase
import ru.suslikkrol.shoppinglistmentor.domain.GetShopListUseCase
import ru.suslikkrol.shoppinglistmentor.domain.ShopItem
import ru.suslikkrol.shoppinglistmentor.domain.ShopListRepository

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopListUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopList(shopItem: ShopItem) {
        deleteShopListUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopListUseCase.editShopItem(newItem)
    }
}
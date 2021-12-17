package com.qmc.library

import androidx.fragment.app.FragmentActivity

/**
 * @ProjectName:PermissionX
 * @Description:
 * @Author:qimengchao
 * @Date:2021/12/17 09:27
 */
object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(activity:FragmentActivity,vararg permissions:String,callback: PermissionCallback) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val invisibleFragment = if(existedFragment!=null) {
            existedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment,TAG).commitNow()
            invisibleFragment
        }
        // 这里的星号是将数组转换城可变长度参数传递过去
        invisibleFragment.requestNow(callback,*permissions)
    }

}
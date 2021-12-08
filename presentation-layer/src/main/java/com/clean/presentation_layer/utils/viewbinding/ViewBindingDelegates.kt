package com.clean.presentation_layer.utils.viewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.lifecycle.Lifecycle.Event.*
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class FragmentViewBindingDelegate<T : ViewBinding>(
    val fragment: Fragment,
    val viewBindingFactory: (View) -> T
) : ReadOnlyProperty<Fragment, T> {
    private var binding: T? = null

//    init {
//        fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
//            val viewLifecycleOwnerLiveDataObserver =
//                Observer<LifecycleOwner?> {
//                    val viewLifecycleOwner = it ?: return@Observer
//
//                    viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
//                        override fun onDestroy(owner: LifecycleOwner) {
//                            binding = null
//                        }
//                    })
//                }
//
//            override fun onCreate(owner: LifecycleOwner) {
//                fragment.viewLifecycleOwnerLiveData.observeForever(viewLifecycleOwnerLiveDataObserver)
//            }
//
//            override fun onDestroy(owner: LifecycleOwner) {
//                fragment.viewLifecycleOwnerLiveData.removeObserver(viewLifecycleOwnerLiveDataObserver)
//            }
//        })
//    }

    init {
        fragment.lifecycle.addObserver(object : LifecycleEventObserver {
            val viewLifecycleOwnerLiveDataObserver =
                Observer<LifecycleOwner?> {
                    val viewLifecycleOwner = it ?: return@Observer
                    viewLifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {

                        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                            if (event == ON_DESTROY) {
                                binding = null
                            }
                        }
                    })
                }

            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == ON_CREATE) {
                    fragment.viewLifecycleOwnerLiveData.observeForever(viewLifecycleOwnerLiveDataObserver)
                } else if (event == ON_DESTROY) {
                    fragment.viewLifecycleOwnerLiveData.removeObserver(viewLifecycleOwnerLiveDataObserver)
                }
            }

        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = binding
        if (binding != null) {
            return binding
        }

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.")
        }

        return viewBindingFactory(thisRef.requireView()).also { this.binding = it }
    }
}

/** Activity binding delegate, may be used since onCreate up to onDestroy (inclusive) */
inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T) =
    lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }

/** Fragment binding delegate, may be used since onViewCreated up to onDestroyView (inclusive) */
fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFactory)

/** Binding delegate for DialogFragments implementing onCreateDialog (like Activities, they don't
 *  have a separate view lifecycle), may be used since onCreateDialog up to onDestroy (inclusive) */
inline fun <T : ViewBinding> DialogFragment.viewBinding(crossinline factory: (LayoutInflater) -> T) =
    lazy(LazyThreadSafetyMode.NONE) {
        factory(layoutInflater)
    }

/** Not really a delegate, just a small helper for RecyclerView.ViewHolders */
inline fun <T : ViewBinding> ViewGroup.viewBinding(factory: (LayoutInflater, ViewGroup, Boolean) -> T) =
    factory(LayoutInflater.from(context), this, false)

// https://gist.github.com/gmk57/aefa53e9736d4d4fb2284596fb62710d
// https://github.com/androidbroadcast/ViewBindingPropertyDelegate
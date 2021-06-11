package sharaev.slava.ra.di

import dagger.Module

@Module(
    subcomponents = [
        LoginComponent::class,
    ]
)
interface AppSubcomponents
